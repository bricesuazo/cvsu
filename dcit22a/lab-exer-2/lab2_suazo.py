scorePlayer1 = int(input('Enter Player 1 Score: '))
scorePlayer2 = int(input('Enter Player 2 Score: '))

if scorePlayer1 > scorePlayer2:
    print('Player 1 won!')
elif scorePlayer1 < scorePlayer2:
    print('Player 2 won!')
elif scorePlayer1 == scorePlayer2:
    print("It's a Tie!")
else:
    print('You have entered either not a score, or a number.')