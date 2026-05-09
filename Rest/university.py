students = {}

official_courses = [
    "Math", "Physics", "Computer Science", "Biology", "Chemistry",
    "Statistics", "English", "Economics", "History", "Philosophy",
    "Sociology", "Political Science", "Geography", "Psychology", "Art",
    "Music", "Engineering", "Law", "Medicine", "Business"
]

def add_student(username, name, age, city, zip_code, courses):
    if not username.strip():
        return "Username cannot be empty"

    if not courses:
        return "Course list cannot be empty"

    if username in students:
        return "Username already exists"

    students[username] = {
        "name": name,
        "age": age,
        "address": {
            "city": city,
            "zip": zip_code
        },
        "courses": set(courses)
    }

    return "Student added successfully"


def get_student(username):
    return students.get(username, "Student not found")


def get_courses(username):
    student = students.get(username)
    if not student:
        return "Student not found"
    return student["courses"]


def get_zip(username):
    student = students.get(username)
    if not student:
        return "Student not found"
    return student["address"]["zip"]


def get_city(username):
    student = students.get(username)
    if not student:
        return "Student not found"
    return student["address"]["city"]


def add_course(username, course):
    student = students.get(username)

    if not student:
        return "Student not found"

    if course not in official_courses:
        return "Course not offered"

    if course in student["courses"]:
        return "Duplicate course not allowed"

    student["courses"].add(course)
    return "Course added"


def remove_course(username, course):
    student = students.get(username)

    if not student:
        return "Student not found"

    student["courses"].discard(course)
    return "Course removed"


def update_course(username, old_course, new_course):
    student = students.get(username)

    if not student:
        return "Student not found"

    if new_course not in official_courses:
        return "New course not offered"

    student["courses"].discard(old_course)
    student["courses"].add(new_course)

    return "Course updated"


def update_student(username, name=None, age=None, city=None, zip_code=None):
    student = students.get(username)

    if not student:
        return "Student not found"

    if name:
        student["name"] = name
    if age:
        student["age"] = age
    if city:
        student["address"]["city"] = city
    if zip_code:
        student["address"]["zip"] = zip_code

    return "Student updated"


def total_students():
    return len(students)


def main():
    print ("Welcome To Bright Future University")
    while True:
        print("\n--- Student System ---")
        print("1. Add Student")
        print("2. View Student")
        print("3. View Courses")
        print("4. Add Course")
        print("5. Total Students")
        print("6. Exit")

        choice = input("Enter choice: ")

        if choice == "1":
            username = input("Enter Your Username: ")
            name = input("Enter Your Name: ")
            age = int(input("Enter Your Age: "))
            city = input("Enter Your City: ")
            zip_code = input("Enter Your Zip code: ")
            courses = input("Enter Your Courses: ").split(",")

            result = add_student(username, name, age, city, zip_code, courses)
            print(result)

        elif choice == "2":
            username = input("Enter Your Username: ")
            print(get_student(username))

        elif choice == "3":
            username = input("Enter Your Username: ")
            print(get_courses(username))

        elif choice == "4":
            username = input(" Enter Your Username: ")
            course = input("Enter The Course: ")
            print(add_course(username, course))

        elif choice == "5":
            print(total_students())

        elif choice == "6":
            print("Thank you for using Bright Future University App")
            break


