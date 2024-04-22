from sys import stdin

readline = stdin.readline

def is_palindrome(string):
    s, e = 0, len(string) - 1
    
    while s < e:
        if string[s] != string[e]:
            return False
        
        s += 1
        e -= 1
    
    return True    

if __name__ == "__main__":
    while True:
        number_string = readline().rstrip()
        
        if number_string == "0":
            break
        
        if number_string == str(int(number_string)) and is_palindrome(number_string):
            print('yes')
        else:
            print('no')