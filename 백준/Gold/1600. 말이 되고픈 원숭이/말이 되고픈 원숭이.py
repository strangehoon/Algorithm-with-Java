from collections import deque
import sys

k = int(input())
w, h = map(int, input().split())
graph = []

for i in range(h):
    graph.append(list(map(int, sys.stdin.readline().split())))

# 동 서 남 북
dx = [0, 0, 1, -1,-2, -1, 1, 2, 2, 1, -1, -2]
dy = [1, -1, 0, 0, 1, 2, 2, 1, -1, -2, -2, -1]
visited =[[[False] * w for _ in range(h)] for _ in range(k+1)]

def bfs(x, y, count,k):
    queue = deque([(x,y, count,k)])
    visited[k][x][y] = True
    while(queue):
        x,y,count,k = queue.popleft()
        if x == h - 1 and y == w - 1:
            print(count)
            return
        # 동 서 남 북 이동
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if 0<=nx<h and 0<=ny<w:
                if visited[k][nx][ny]==False and graph[nx][ny]==0:
                    queue.append((nx, ny, count + 1, k))
                    visited[k][nx][ny] = True
        # 체스 나이트 이동
        if k > 0:
            for i in range(4, 12):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < h and 0 <= ny < w:
                    if visited[k-1][nx][ny]==False and graph[nx][ny]==0:
                        queue.append((nx, ny, count + 1, k-1))
                        visited[k-1][nx][ny] = True
    print(-1)
    return

bfs(0, 0, 0, k)
