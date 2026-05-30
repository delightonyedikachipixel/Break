from unittest import TestCase
from tic_tac_toe import *

class TestClass(TestCase):


    def test_board_is_empty_initially(self):
        board = create_board()
        for row in board:
            for cell in row:
                self.assertEqual(cell, " ")


    def test_insert_invalid_low_position(self):
        board = create_board()
        success, message = insert_value(board, 0, "X")
        self.assertFalse(success)

    def test_insert_invalid_high_position(self):
        board = create_board()
        success, message = insert_value(board, 10, "X")
        self.assertFalse(success)

    def test_insert_on_taken_position(self):
        board = create_board()
        insert_value(board, 5, "X")
        success, message = insert_value(board, 5, "O")
        self.assertFalse(success)

    def test_insert_last_position(self):
        board = create_board()
        success, message = insert_value(board, 9, "X")
        self.assertTrue(success)
        self.assertEqual(board[2][2], "X")


    def test_no_winner_on_empty_board(self):
        board = create_board()
        self.assertFalse(validate_winner(board, "X"))

    def test_no_winner_partial_board(self):
        board = create_board()
        board[0][0] = "X"
        board[1][1] = "X"
        self.assertFalse(validate_winner(board, "X"))

    def test_row_winner(self):
        board = create_board()
        board[1] = ["O", "O", "O"]
        self.assertTrue(validate_winner(board, "O"))

    def test_column_winner(self):
        board = create_board()
        board[0][2] = "X"
        board[1][2] = "X"
        board[2][2] = "X"
        self.assertTrue(validate_winner(board, "X"))

    


    def test_full_board_draw(self):
        board = [
            ["X", "O", "X"],
            ["X", "O", "O"],
            ["O", "X", "X"]
        ]
        self.assertFalse(validate_winner(board, "X"))
        self.assertFalse(validate_winner(board, "O"))


    def test_multiple_insertions(self):
        board = create_board()
        insert_value(board, 1, "X")
        insert_value(board, 2, "O")
        insert_value(board, 3, "X")
        self.assertEqual(board[0], ["X", "O", "X"])
