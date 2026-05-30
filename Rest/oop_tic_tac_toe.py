class TicTacToe:
    def __init__(self):
        self.game_board = self.create_board()

    def create_board(self):
        return [[" " for _ in range(3)] for _ in range(3)]

    def display_positions(self):
        position_number = 1
        for row_index in range(3):
            for column_index in range(3):
                print(position_number, end=" ")
                position_number += 1
            print()

    def display_board(self):
        for row in self.game_board:
            print("|".join(row))
            print("-" * 5)

    def insert_move(self, position, player_symbol):
        if position < 1 or position > 9:
            return False, "Invalid position"

        row_index = (position - 1) // 3
        column_index = (position - 1) % 3

        if self.game_board[row_index][column_index] == " ":
            self.game_board[row_index][column_index] = player_symbol
            return True, "Move inserted"
        else:
            return False, "Position already taken"

    def check_winner(self, player_symbol):

        for row_index in range(3):
            row_has_winner = True

            for column_index in range(3):
                if self.game_board[row_index][column_index] != player_symbol:
                    row_has_winner = False
                    break

            if row_has_winner:
                return True


        for column_index in range(3):
            column_has_winner = True

            for row_index in range(3):
                if self.game_board[row_index][column_index] != player_symbol:
                    column_has_winner = False
                    break

            if column_has_winner:
                return True


        main_diagonal_winner = True
        for diagonal_index in range(3):
            if self.game_board[diagonal_index][diagonal_index] != player_symbol:
                main_diagonal_winner = False
                break

        if main_diagonal_winner:
            return True


        reverse_diagonal_winner = True
        for diagonal_index in range(3):
            if self.game_board[diagonal_index][2 - diagonal_index] != player_symbol:
                reverse_diagonal_winner = False
                break

        if reverse_diagonal_winner:
            return True

        return False
