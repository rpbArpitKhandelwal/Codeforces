# sync_cf.py

import os

from cf_client import fetch_submissions
from state_manager import StateManager
from normalizer import java_file_path, problem_id
from git_manager import git_commit
from config import *

def main():
    os.makedirs(OUTPUT_DIR, exist_ok=True)

    state = StateManager(STATE_FILE)
    submissions = fetch_submissions(CF_HANDLE, MAX_SUBMISSIONS_FETCH)

    for sub in submissions:
        if sub.get("verdict") != "OK":
            continue

        submission_id = sub["id"]

        if state.is_processed(submission_id):
            continue

        problem = sub["problem"]
        file_path = java_file_path(OUTPUT_DIR, problem)

        # Never overwrite user code
        if os.path.exists(file_path):
            state.mark_processed(submission_id)
            state.save()
            continue

        header = (
            f"// Platform: Codeforces\n"
            f"// Problem: {problem_id(problem)} - {problem['name']}\n"
            f"// Submission ID: {submission_id}\n"
            f"// Status: Accepted\n"
            f"// URL: https://codeforces.com/contest/{problem['contestId']}/submission/{submission_id}\n\n"
            f"// TODO:\n"
            f"// Paste your accepted Java solution here.\n"
        )

        with open(file_path, "w", encoding="utf-8") as f:
            f.write(header)

        git_commit(
            file_path,
            f"CF: {problem_id(problem)} - {problem['name']} (Accepted)"
        )

        state.mark_processed(submission_id)
        state.save()

if __name__ == "__main__":
    main()
