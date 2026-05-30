
board = create_board()
moves = 0

print("Positions:")
display_positions()


player1_name = input("Enter Player 1 name: ")
player2_name = input("Enter Player 2 name: ")


player1_symbol = input(f"{player1_name}, choose X or O: ").upper()

while player1_symbol not in ["X", "O"]:
    player1_symbol = input("Invalid choice. Choose X or O: ").upper()


player2_symbol = "O" if player1_symbol == "X" else "X"


current_player = player1_symbol

while True:
    print("\nCurrent Board:")
    display_board(board)


    if current_player == player1_symbol:
        current_name = player1_name
    else:
        current_name = player2_name

    try:
        pos = int(input(f"{current_name} ({current_player}), choose position (1-9): "))
    except ValueError:
        print("Please enter a number!")
        continue

    success, message = insert_value(board, pos, current_player)

    if not success:
        print(message)
        continue

    moves += 1

    if validate_winner(board, current_player):
        display_board(board)
        print(f" Congrats {current_name}! You win!")
        break

    if moves == 9:
        display_board(board)
        print("It's a draw!")
        break


    current_player = player2_symbol if current_player == player1_symbol else player1_symbol
