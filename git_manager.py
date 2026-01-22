# git_manager.py

import subprocess

def git_commit(file_path, message):
    subprocess.run(["git", "add", file_path], check=True)
    subprocess.run(["git", "commit", "-m", message], check=True)
