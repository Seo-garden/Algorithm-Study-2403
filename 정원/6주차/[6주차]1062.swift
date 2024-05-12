import Foundation

var NK = readLine()!.split(separator: " ").map({ Int($0)! })
var N = NK[0], K = NK[1]

var wordsBit = Array(repeating: 0, count: 50)
var alphabet = 0        //아스키코드 값 저장변수
var result = 0

for i in 0..<N {
    let input = readLine()!.map({ String($0) })
    for j in input {
        //입력을 받을 때 마다 아스키코드값을 배열에 저장 해당 알파벳이 어디에 위치하는지 파악하기 위함
        wordsBit[i] |= 1 << (Int(Character(j).asciiValue! - (Character("a").asciiValue!)))
    }
}

func DFS(_ depth: Int, _ start: Int) {
    var count = 0
    if depth == K {     //탐색을 알파벳 갯수만큼 탐색했으면
        for i in 0..<N {
            if wordsBit[i] & alphabet == wordsBit[i] {      //wordsBit[i] 에 알파벳 아스키코드가 포함되어 있다면
                count += 1
            }
        }
        result = max(result, count)
        return
    }
    for i in start...25 {       //K 가 26보다 작거나 같거나 0 이니까
        if (alphabet & (1 << i)) == 0 {     //
            alphabet |= (1 << i)        //선택
            DFS(depth+1, i)
            alphabet &= ~(1 << i)       //취소
        }
    }
}

func solved() -> Int {
    if K < 5 { return 0 }
    //a,c,i,n,t 이미 알고있으니까
    //alphabet 에 읽을 수 있는 단어 저장
    alphabet |= 1 << (Int(Character("a").asciiValue! - Character("a").asciiValue!))
    alphabet |= 1 << (Int(Character("n").asciiValue! - Character("a").asciiValue!))
    alphabet |= 1 << (Int(Character("t").asciiValue! - Character("a").asciiValue!))
    alphabet |= 1 << (Int(Character("i").asciiValue! - Character("a").asciiValue!))
    alphabet |= 1 << (Int(Character("c").asciiValue! - Character("a").asciiValue!))
    
    K = K - 5
    DFS(0, 0)
    
    return result
}

print(solved())
