"""
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"
"""


class Solution:
    VOWELS = set(["a", "e", "i", "o", "u"])

    def reverseVowels(self, s: str) -> str:
        word: List[str] = list(s)
        vowelPositions = [i for i, char in enumerate(s) if char.lower() in self.VOWELS]

        left: int = 0
        right: int = len(vowelPositions) - 1

        while left <= right:
            l = vowelPositions[left]
            r = vowelPositions[right]

            word[l], word[r] = word[r], word[l]

            left += 1
            right -= 1

        return "".join(word)
