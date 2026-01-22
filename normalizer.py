# normalizer.py

import os
import re

def sanitize(name: str) -> str:
    return re.sub(r"[^a-zA-Z0-9]+", "_", name).strip("_")

def problem_id(problem):
    return f"{problem['contestId']}{problem['index']}"

def java_file_path(base_dir, problem):
    name = sanitize(problem["name"])
    pid = problem_id(problem)
    filename = f"{name}_{pid}.java"
    return os.path.join(base_dir, filename)
