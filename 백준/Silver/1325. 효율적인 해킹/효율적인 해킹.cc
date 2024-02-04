#include<bits/stdc++.h>
 
using namespace std;
 
int n, m;
vector<int> vec[10001];
vector<bool> vis(10001, false);
vector<pair<int, int>> answerCnt;
int maxCnt = -9761234;
 
int BFS(int n) {
    vis.assign(10001, false);
 
    int cnt = 0;
    queue<int> q;
 
    q.push(n);
 
    vis[n] = true;
 
    while(!q.empty()) {
        int cur = q.front();
        cnt++;
        q.pop();
 
        for(auto a : vec[cur]) {
            if(vis[a]) continue;
            vis[a] = true;
            q.push(a);
        }
    }
 
    if(maxCnt < cnt) {
        answerCnt.clear();
        answerCnt.push_back({n, cnt});
    }
    else if(maxCnt == cnt) {
        answerCnt.push_back({n, cnt});
    }
 
    return cnt;
}
 
int main() {
    ios_base::sync_with_stdio(false); cout.tie(0); cin.tie(0);
 
    cin >> n >> m;
 
    for(int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
 
        vec[b].push_back(a);
    }
 
    for(int i = 1; i <= n; i++) {
        maxCnt = max(maxCnt, BFS(i));
    }
 
    sort(answerCnt.begin(), answerCnt.end());
 
    for(int i = 0; i < answerCnt.size(); i++) {
            cout << answerCnt[i].first << " ";
    }
}