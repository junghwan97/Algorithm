import sys
n = int(sys.stdin.readline().strip())

words = [sys.stdin.readline().strip() for _ in range(n)]

unique_sorted_words = sorted(set(words), key = lambda x: (len(x), x))
print("\n".join(unique_sorted_words))