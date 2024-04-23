from sys import stdin
import re

readline = stdin.readline

REGEX = r'[^\(\)\[\]]'
ALLOWS = {
    '(', '['
}
PAIRS = {
    '(': ')',
    '[': ']',
}

def solution(string):
    temp = []
    
    for s in string:
        if s in ALLOWS:
            temp.append(s)
            continue
        
        if not temp or PAIRS[temp[-1]] != s:
            return False
        
        temp.pop()
            
    return not temp

if __name__ == '__main__':
    while True:
        string = readline().rstrip()
        
        if string == '.':
            break

        print("yes" if solution(re.sub(REGEX, '', string)) else "no")
