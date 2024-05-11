var NM = readLine()!.split(separator: " ").map({ Int(String($0))! })
var N = NM[0], M = NM[1]
var number = readLine()!.split(separator: " ").map({ Int(String($0))! }).sorted()

var result = [String]()     //탐색결과
var visited = [Bool](repeating: false, count: N+1)
var checked = Set<String>()     //중복체크


func dfs(_ depth: Int) {
    for i in 0..<N {
        if depth == M {
            let resultString = result.joined(separator: " ")        //중복 체크하고 중복되지 않으면 출력
            if !checked.contains(resultString) {
                checked.insert(resultString)
                print(resultString)
            }
            return
        }
        if !visited[i] {
            visited[i] = true
            result.append(String(number[i]))
            dfs(depth + 1)
            visited[i] = false
            result.removeLast()
        }
    }
}
dfs(0)
