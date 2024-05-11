//4월 16일 화요일 오후 7시 시작 - 재료를 다 쓸 필요가 없다
//도저히 감을 못잡아서
import Foundation

let N = Int(readLine()!)!
var taste = [[Int]](repeating: [Int](), count: N)

for i in 0..<N {
    taste[i] = readLine()!.split(separator: " ").map { Int($0)! }
}

var answer = Int.max

for i in 1..<(1 << N) {     //이게 2의 N 제곱과 동일하다. 1부터는 공집합제거를 위함
    var S = 1 // 재료의 곱을 저장할 변수      가능한 조합을 나타내기 위해 0과 1 사용
    var B = 0 // 재료의 합을 저장할 변수
    // 각 비트에 대해 재료의 정보를 확인하며 계산
    for j in 0..<N {
        if (i & (1 << j)) != 0 { // 만약 3을 입력했을 때 000 인 경우는 제외해야 함. 재료가 적어도 하나는 사용해야 하기 때문이다.
            //N 이 3이라고 입력했을 때 000, 001, 010, 011, 100, 101, 110, 111
            S *= taste[j][0] // 해당 재료의 양을 누적곱
            B += taste[j][1] // 해당 재료의 비용을 누적합
        }
    }
    //최소값
    answer = min(answer, Int(abs(S - B)))   //절댓값
}
print(answer)
