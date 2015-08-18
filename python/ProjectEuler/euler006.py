if __name__ == "__main__":
    sumN = 0
    sumSq = 0
    for i in range (1, 101):
        sumN += i
        sumSq += i * i
    print sumN * sumN - sumSq 