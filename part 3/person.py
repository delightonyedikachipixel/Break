from problem import Problem

class Person:
    def __init__(self, name: str):
        self.name = name
        self._problems: list[Problem] = []

    def add_problem(self, problem: Problem):
        self._problems.append(problem)

    def solve_problem(self, name: str):
        for problem in self._problems:
            if problem.name.lower() == name.lower():
                problem.solve()
                return
        raise ValueError(f"No problem named '{name}' found.")

    def recount_problems(self) -> list[Problem]:
        return [problem for problem in self._problems if not problem.is_solved]

    def __str__(self):
        unsolved = self.recount_problems()
        lines = [f"Person: {self.name}"]
        lines.append(f"  Unsolved problems ({len(unsolved)}):")
        for problem in unsolved:
            lines.append(f"    - {problem}")
        return "\n".join(lines)