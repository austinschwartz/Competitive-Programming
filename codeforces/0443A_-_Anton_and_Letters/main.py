print(len(set(filter(lambda i: len(i) > 0, list(map(lambda i: i.strip(), input()[1:-1].split(',')))))))
