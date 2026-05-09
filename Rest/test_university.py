import unittest
import university


class TestStudentSystem(unittest.TestCase):

    def setUp(self):
        university.students.clear()

        university.add_student(
            "heavian",
            "Heavian",
            16,
            "Abuja",
            "100001",
            ["Math", "Law"]
        )


    def test_add_student_with_unique_username_returns_success_message(self):
        result = university.add_student(
            "kamtoofine", "Kamsi", 20, "Calabar", "800001", ["Biology"]
        )
        self.assertEqual(result, "Student added successfully")

    def test_add_student_with_existing_username_returns_error_message(self):
        result = university.add_student(
            "heavian", "Another Heavian", 18, "Abuja", "100001", ["Math"]
        )
        self.assertEqual(result, "Username already exists")

    def test_get_student_with_valid_username_returns_student_dictionary(self):
        student_record = university.get_student("heavian")
        self.assertEqual(student_record["name"], "Heavian")

    def test_get_student_with_invalid_username_returns_not_found_message(self):
        result = university.get_student("ghost")
        self.assertEqual(result, "Student not found")

    def test_get_courses_with_valid_username_returns_course_set(self):
        course_set = university.get_courses("heavian")
        self.assertIn("Math", course_set)

    def test_add_course_with_valid_course_adds_course_successfully(self):
        result = university.add_course("heavian", "Chemistry")
        self.assertEqual(result, "Course added")

    def test_add_course_with_duplicate_course_returns_error_message(self):
        result = university.add_course("heavian", "Math")
        self.assertEqual(result, "Duplicate course not allowed")

    def test_add_course_with_unofficial_course_returns_error_message(self):
        result = university.add_course("heavian", "CODM")
        self.assertEqual(result, "Course not offered")

    def test_remove_course_existing_course_removes_course_successfully(self):
        result = university.remove_course("heavian", "Math")
        self.assertEqual(result, "Course removed")

    def test_update_course_valid_replacement_updates_course_successfully(self):
        result = university.update_course("heavian", "Math", "Biology")
        self.assertEqual(result, "Course updated")

    def test_get_zip_with_valid_username_returns_correct_zip_code(self):
        self.assertEqual(university.get_zip("heavian"), "100001")

    def test_get_city_with_valid_username_returns_correct_city_name(self):
        self.assertEqual(university.get_city("heavian"), "Abuja")

    def test_update_student_with_valid_data_updates_all_fields_successfully(self):
        result = university.update_student(
            "heavian",
            name="Heavian Updated",
            age=18,
            city="Lagos",
            zip_code="200002"
        )
        self.assertEqual(result, "Student updated")

    def test_total_students_returns_correct_number_of_students(self):
        self.assertEqual(university.total_students(), 1)


    def test_add_student_with_empty_username_returns_error_message(self):
        result = university.add_student(
            "", "Heavian", 16, "Abuja", "100001", ["Math"]
        )
        self.assertEqual(result, "Username cannot be empty")

    def test_add_student_with_whitespace_username_returns_error_message(self):
        result = university.add_student(
            "   ", "Heavian", 16, "Abuja", "100001", ["Math"]
        )
        self.assertEqual(result, "Username cannot be empty")

    def test_add_student_with_empty_course_list_returns_error_message(self):
        result = university.add_student(
            "newuser", "Heavian", 16, "Abuja", "100001", []
        )
        self.assertEqual(result, "Course list cannot be empty")


