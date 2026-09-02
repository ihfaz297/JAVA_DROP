# Submission Endpoint Inspector & Auto-Upload Configurator
param(
    [string]$TargetUrl = "http://10.100.94.209:5000/",
    [string]$FileToUpload = "C:\Users\adib\Desktop\JAVA_DROP\L06_2022331008.java"
)

function Inspect-Endpoint {
    param([string]$Url)

    Write-Host ""
    Write-Host "=== ENDPOINT INSPECTION ===" -ForegroundColor Cyan

    try {
        $response = Invoke-WebRequest -Uri $Url -TimeoutSec 5 -ErrorAction Stop

        Write-Host "Status Code: $($response.StatusCode)" -ForegroundColor Green
        Write-Host "Content Type: $($response.Headers['Content-Type'])"
        Write-Host "Content Length: $($response.Content.Length) bytes"

        try {
            $json = $response.Content | ConvertFrom-Json
            Write-Host ""
            Write-Host "JSON Response:" -ForegroundColor Yellow
            $json | ConvertTo-Json | Write-Host
        } catch {
            Write-Host ""
            Write-Host "Raw Response (first 500 chars):" -ForegroundColor Yellow
            Write-Host $response.Content.Substring(0, [Math]::Min(500, $response.Content.Length))
        }

        if ($response.Headers['Content-Type'] -like '*html*') {
            Write-Host ""
            Write-Host "--- HTML Form Analysis ---" -ForegroundColor Cyan
            $html = $response.Content

            if ($html -match '<form[^>]*>(.*?)</form>' -or $html -match '<input[^>]*>') {
                $inputs = [regex]::Matches($html, '<input[^>]*>')
                Write-Host "Found $($inputs.Count) input fields:" -ForegroundColor Yellow
                foreach ($input in $inputs) {
                    Write-Host "  - $($input.Value)"
                }
            }
        }

        return $response
    } catch {
        Write-Host "Connection failed: $($_.Exception.Message)" -ForegroundColor Red
        return $null
    }
}

function Test-AutoUpload {
    param([string]$Url, [string]$FilePath)

    Write-Host ""
    Write-Host "=== AUTO-UPLOAD TEST ===" -ForegroundColor Cyan

    if (-not (Test-Path $FilePath)) {
        Write-Host "File not found: $FilePath" -ForegroundColor Red
        return $false
    }

    Write-Host "File: $(Split-Path $FilePath -Leaf)" -ForegroundColor Green
    Write-Host "Size: $((Get-Item $FilePath).Length) bytes"

    try {
        Write-Host ""
        Write-Host "Attempting multipart form upload..." -ForegroundColor Yellow

        $form = @{
            file = Get-Item $FilePath
        }

        $uploadResponse = Invoke-WebRequest -Uri $Url -Method POST -Form $form -TimeoutSec 5
        Write-Host "Multipart upload successful!" -ForegroundColor Green
        Write-Host "Response Status: $($uploadResponse.StatusCode)"

        return $true
    } catch {
        Write-Host "Multipart upload failed: $($_.Exception.Message)" -ForegroundColor Yellow

        try {
            Write-Host "Attempting raw file upload..." -ForegroundColor Yellow
            $fileBytes = [System.IO.File]::ReadAllBytes($FilePath)
            $uploadResponse = Invoke-WebRequest -Uri $Url -Method POST -Body $fileBytes -ContentType "application/octet-stream" -TimeoutSec 5
            Write-Host "Raw file upload successful!" -ForegroundColor Green
            return $true
        } catch {
            Write-Host "Raw upload also failed: $($_.Exception.Message)" -ForegroundColor Yellow
            return $false
        }
    }
}

function Save-AutoUploadConfig {
    Write-Host ""
    Write-Host "=== SAVING CONFIGURATION ===" -ForegroundColor Cyan

    $config = @{
        SubmissionUrl = $TargetUrl
        FileToUpload = $FileToUpload
        FileName = Split-Path $FileToUpload -Leaf
        Timestamp = Get-Date
        AutoUploadEnabled = $false
    } | ConvertTo-Json

    $configPath = "C:\Users\adib\Desktop\JAVA_DROP\submission_config.json"
    $config | Out-File $configPath -Force

    Write-Host "Config saved to: $configPath" -ForegroundColor Green
    Write-Host "To enable auto-upload on future links, update submission_config.json" -ForegroundColor Yellow
}

# Main execution
Write-Host "Submission Endpoint Inspector" -ForegroundColor Magenta
Write-Host "=============================" -ForegroundColor Magenta

$maxWait = 60
$waited = 0
$isOnline = $false

Write-Host "Checking if endpoint is online..."
while ($waited -lt $maxWait -and -not $isOnline) {
    try {
        $test = Invoke-WebRequest -Uri $TargetUrl -TimeoutSec 3 -ErrorAction Stop
        $isOnline = $true
        Write-Host "Endpoint is online!" -ForegroundColor Green
    } catch {
        $waited += 5
        if ($waited -lt $maxWait) {
            Write-Host "  Waiting... $waited/$maxWait seconds"
            Start-Sleep -Seconds 5
        }
    }
}

if ($isOnline) {
    Inspect-Endpoint $TargetUrl
    Test-AutoUpload $TargetUrl $FileToUpload
    Save-AutoUploadConfig

    Write-Host ""
    Write-Host "=== SUMMARY ===" -ForegroundColor Cyan
    Write-Host "Configuration saved. For future submissions:"
    Write-Host "1. Review submission_config.json"
    Write-Host "2. Implement auto-upload based on endpoint requirements"
    Write-Host "3. Setup scheduled task to auto-upload when link appears"
} else {
    Write-Host "Endpoint did not come online within $maxWait seconds" -ForegroundColor Red
}

Write-Host ""
Write-Host "Inspection complete." -ForegroundColor Green
