#!/usr/bin/env python3
import requests
import sys

url = "http://10.100.94.157:5000/"
reg_no = "2022331008"
file_path = r"C:\Users\adib\Desktop\JAVA_DROP\L06_2022331008.java"

try:
    with open(file_path, 'rb') as f:
        files = {'file': f}
        data = {'reg_no': reg_no}

        response = requests.post(url, files=files, data=data, timeout=10)

        # Check for success
        if 'alert-success' in response.text:
            print("[SUCCESS] File submitted!")
            # Extract success message
            import re
            match = re.search(r'<div class="alert alert-success">(.*?)</div>', response.text)
            if match:
                print(f"Message: {match.group(1).strip()}")
        elif 'alert-error' in response.text:
            print("[ERROR] Submission failed:")
            import re
            matches = re.findall(r'<div class="alert alert-error">(.*?)</div>', response.text)
            for msg in matches:
                print(f"  - {msg.strip()}")
        else:
            print(f"Response status: {response.status_code}")

except FileNotFoundError:
    print(f"❌ File not found: {file_path}")
except Exception as e:
    print(f"❌ Error: {e}")
