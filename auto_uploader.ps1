# Auto-Upload Manager - Runs until endpoint comes online and handles submission
param(
    [string]$TargetUrl = "http://10.100.94.209:5000/",
    [string]$FileToUpload = "C:\Users\adib\Desktop\JAVA_DROP\L06_2022331008.java"
)

Write-Host "Auto-Upload Manager Starting" -ForegroundColor Magenta
Write-Host "============================="
Write-Host "Target: $TargetUrl"
Write-Host "File: $(Split-Path $FileToUpload -Leaf)"
Write-Host ""

$configPath = "C:\Users\adib\Desktop\JAVA_DROP\submission_config.json"

while ($true) {
    try {
        $response = Invoke-WebRequest -Uri $TargetUrl -TimeoutSec 5 -ErrorAction Stop

        Write-Host "ENDPOINT DETECTED - Status $($response.StatusCode)" -ForegroundColor Green
        Write-Host "Content-Type: $($response.Headers['Content-Type'])" -ForegroundColor Green
        Write-Host ""

        # Save endpoint info
        $endpointInfo = @{
            DetectedTime = Get-Date
            StatusCode = $response.StatusCode
            ContentType = $response.Headers['Content-Type']
            ContentLength = $response.Content.Length
            IsJson = $response.Headers['Content-Type'] -like '*json*'
            IsHtml = $response.Headers['Content-Type'] -like '*html*'
            AvailableUntil = (Get-Date).AddMinutes(5)
        }

        # Try auto-upload
        Write-Host "Attempting auto-upload..." -ForegroundColor Cyan
        try {
            $form = @{ file = Get-Item $FileToUpload }
            $uploadResponse = Invoke-WebRequest -Uri $TargetUrl -Method POST -Form $form -TimeoutSec 5
            Write-Host "SUCCESS: File uploaded! Status $($uploadResponse.StatusCode)" -ForegroundColor Green
            $endpointInfo | Add-Member -MemberType NoteProperty -Name "UploadStatus" -Value "SUCCESS"
        } catch {
            Write-Host "Upload attempt failed: $($_.Exception.Message)" -ForegroundColor Yellow
            $endpointInfo | Add-Member -MemberType NoteProperty -Name "UploadStatus" -Value "FAILED"
        }

        # Save config for future reference
        $endpointInfo | ConvertTo-Json | Out-File $configPath -Force
        Write-Host "Config saved to: $configPath" -ForegroundColor Green
        break
    } catch {
        # Still waiting
        Start-Sleep -Seconds 10
    }
}
