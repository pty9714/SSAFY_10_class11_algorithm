from collections import defaultdict

def dfs(node, edge_dict, dp) :
    if not edge_dict[node] :
        return
    
    cnt, zero_cnt, min_val, min_diff = 0, 0, 0, float('inf')
    for leaf in edge_dict[node] :
        dfs(leaf, edge_dict, dp)
        min_val += min(dp[leaf])
        cnt += 1
        
        # 0 -> 해당 노드 미포함
        # 1 -> 해당 노드 포함
        if dp[leaf][0] < dp[leaf][1]:
            zero_cnt += 1
            min_diff = min(min_diff, dp[leaf][1] - dp[leaf][0])
            
    dp[node][1] += min_val
    dp[node][0] += min_val + min_diff if cnt == zero_cnt else min_val

def solution(sales, links):
    dp = [[0,0]] + [[0, sale] for sale in sales]
    
    # 초기화
    edge_dict = defaultdict(list)
    for a, b in links :
        edge_dict[a].append(b)
        
    # DFS
    dfs(1, edge_dict, dp)
    
    return min(dp[1])
