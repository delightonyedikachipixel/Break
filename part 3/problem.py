from enum import Enum

class ProblemType(Enum):
    FINANCIAL = "Financial"
    BUSINESS = "Business"
    TECHNICAL = "Technical"
    EDUCATION = "Education"

class Problem:
    def __init__(self, name: str, problem_type: ProblemType):
        self.name = name
        self.problem_type = problem_type
        self.is_solved = False

    def solve(self):
        self.is_solved = True

    def __str__(self):
        status = "Solved" if self.is_solved else "Unsolved"
        return f"{self.name} ({self.problem_type.value}) - {status}"