import random

words = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine', 'ten']
items = len(words)
correct = 0
incorrect = 0

print('\n----------------------------------------------\n'
'HELLO, WELCOME TO THE WORK SPELLING GAME.\n'
'SPELL AS MUCH NUMBERS AS YOU CAN TO GET MARKS\n'
'----------------------------------------------\n')

r = random.sample(range(items), items)
for i in range(items):
    trial = 2
    inputted_word = input('Spell ' + f'{r[i]}' + ': ').lower()
    
    if words[r[i]] == inputted_word:
        correct += 1
    elif words[r[i]] != inputted_word:
        while trial != 0:
            print('Incorrect spelling. '+ f'{trial}' + ' trial/s left.\n')
            trial -= 1
            inputted_word = input('Spell ' + f'{r[i]}' + ': ').lower()
            if words[r[i]] == inputted_word:
                correct += 1
                break
            if trial == 0:
                incorrect += 1
                print('----- Sorry! Numbers of trials Exceeded -----')

print('\n--------------------------------\nEND OF GAME')
print('CORRECT SPELLING SCORE: %i\nWRONG SPELLING SCORE: %i' % (correct, incorrect))