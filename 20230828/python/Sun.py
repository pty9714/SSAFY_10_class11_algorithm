
result=[]
TC = int(input())
for tc in range(1, 1+TC):
    tree, v = map(int, input().split())
    tree_bin = bin(tree)[2:]
    v_bin = bin(v)[2:]
    tree_depth = len(tree_bin)-1
    v_depth = len(v_bin)-1
    res = tree_depth + v_depth
    if 2**(tree_depth+1)-tree>2**(tree_depth-1) and 2**(v_depth+1)-v>2**(v_depth-1) and tree!=1 and v!=1:
        res -= 1
    result.append(res)
for i in range(1, 1+TC):
    print(f'#{i} {result[i-1]}')


#답봄