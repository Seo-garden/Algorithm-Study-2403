//
//  [4주차]15270.swift
//  
//
//  Created by 서정원 on 4/7/24.
//
//완전탐색 공부좀 더 하고 다시 봐야겠노
import Foundation

var n = 0 // 학생의 수
var m = 0 // 친구 쌍의 수
var friend = [[Int]]() // 친구 쌍을 저장하는 2차원 배열
var visit = [Bool]() // 방문 여부를 저장하는 배열
var answer = 0 // 결과 값

// 메인 함수
// 입력 받기
if let input = readLine()?.split(separator: " ").map({ Int($0)! }) {
    n = input[0]
    m = input[1]
    // 방문 여부 배열 초기화
    visit = [Bool](repeating: false, count: n + 1)
}

// 친구 쌍 입력 받기
friend = [[Int]](repeating: [Int](), count: m)
for i in 0..<m {
    if let input = readLine()?.split(separator: " ").map({ Int($0)! }) {
        let a = input[0]
        let b = input[1]
        friend[i] = [a, b]
    }
}

// DFS 호출
dfs(0, 0)

// 결과 값 계산
answer *= 2
if answer < n {
    answer += 1
}

// 결과 출력
print(answer)


// 깊이 우선 탐색 함수
func dfs(_ depth: Int, _ count: Int) {
    // 모든 친구 쌍을 확인한 경우
    if depth >= m {
        answer = max(answer, count)
        return
    }
    
    // 이미 방문한 친구가 있는 경우
    if visit[friend[depth][0]] || visit[friend[depth][1]] {
        dfs(depth + 1, count)
    } else {
        // 두 친구 모두 방문하지 않은 경우
        visit[friend[depth][0]] = true
        visit[friend[depth][1]] = true
        
        // 친구를 짝지어주는 경우
        dfs(depth + 1, count + 1)
        
        // 친구를 짝지어주지 않는 경우
        visit[friend[depth][0]] = false
        visit[friend[depth][1]] = false
        
        dfs(depth + 1, count)
    }
}
