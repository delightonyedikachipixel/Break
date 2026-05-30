def create_board():
    return [[" " for _ in range(3)] for _ in range(3)]


def display_positions():
    position = 1
    for row in range(3):
        for column in range(3):
            print(position, end=" ")
            position += 1
        print()


def display_board(board):
    for row in board:
        print("|".join(row))
        print("-" * 5)


def insert_value(board, position, player):
    if position < 1 or position > 9:
        return False, "Invalid position"

    row = (position - 1) // 3
    column = (position - 1) % 3

    if board[row][column] == " ":
        board[row][column] = player
        return True, "Inserted"
    else:
        return False, "Position already taken"


def validate_winner(board, player):

    for count in range(3):
        if all(board[count][counter] == player for counter in range(3)):
            return True


    for count in range(3):
        if all(board[counter][count] == player for counter in range(3)):
            return True


    if all(board[count][count] == player for count in range(3)):
        return True

    if all(board[count][2 - count] == player for count in range(3)):
        return True

    return False





