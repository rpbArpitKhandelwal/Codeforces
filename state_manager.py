# state_manager.py

import json
import os

class StateManager:
    def __init__(self, state_file):
        self.state_file = state_file
        self.state = {
            "processed_submission_ids": []
        }
        self._load()

    def _load(self):
        if os.path.exists(self.state_file):
            with open(self.state_file, "r", encoding="utf-8") as f:
                self.state = json.load(f)

    def save(self):
        with open(self.state_file, "w", encoding="utf-8") as f:
            json.dump(self.state, f, indent=2)

    def is_processed(self, submission_id):
        return submission_id in self.state["processed_submission_ids"]

    def mark_processed(self, submission_id):
        self.state["processed_submission_ids"].append(submission_id)
