player1 = input("Enter player1 name: ")
player2 = input("Enter player2 name: ")

player1Choice = input("Player 1, please enter rock, paper or scissor: ").lower()
player2Choice = input("Player 2, please enter rock, paper or scissor: ").lower()

if player1Choice == player2Choice:
    print("Tie!")
elif player1Choice == 'paper':
    if player2Choice == 'scissor':
        print(player2+" with "+player2Choice+" wins!")
    else:
        print(player1+" with "+player1Choice+" wins!")
elif player1Choice == 'rock':
    if player2Choice == 'paper':
        print(player2+" with "+player2Choice+" wins!")
    else:
        print(player1+" with "+player1Choice+" wins!")
elif player1Choice == 'scissor':
    if player2Choice == 'rock':
        print(player2+" with "+player2Choice+" wins!")
    else:
        print(player1+" with "+player1Choice+" wins!")
else:
    print("Incorrect input, Please enter rock, paper or scissor")