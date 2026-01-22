# cf_client.py

import requests

BASE_URL = "https://codeforces.com/api"

def fetch_submissions(handle, limit):
    response = requests.get(
        f"{BASE_URL}/user.status",
        params={"handle": handle, "count": limit},
        timeout=10
    )
    response.raise_for_status()

    data = response.json()
    if data["status"] != "OK":
        raise RuntimeError("Codeforces API returned error")

    return data["result"]
