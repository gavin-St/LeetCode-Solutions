import itertools
def main():
    adj = {'a':['a','b','f','g','j'],
            'b':['b','a','f','i','g','c'], 'c':['c','b','f','h','d'], 'd':['d','c','h','i'], 'e':['e','h','i','j'], 'f':['f','a','b','c','g','h'], 
            'g':['g','f','a','h'], 'h': ['h','f','g','a','c','d','e','i','j'], 'i': ['i','h','b','d','e','j'], 'j':['j','h','i','a','b','e']}
    vis = {'p'}
    keys = list(adj.keys())

    # Create permutations of 6-tuple keys
    for perm in itertools.permutations(keys, 6):
        print(perm)
        vis.add(perm[0])
        vis.add(perm[1])
        vis.add(perm[2])
        vis.add(perm[3])
        vis.add(perm[4])
        vis.add(perm[5])
        for v1 in adj[perm[0]]:
            if v in adj[perm[3]]:
                if not v in vis or v1 == perm[0]



if __name__ == "__main__":
    main()