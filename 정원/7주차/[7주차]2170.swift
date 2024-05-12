import Foundation
//5월 6일 월요일 오후 5시 20분 리딩
//오후 6시 13분 접근방식 리딩
//오후 7시 57분 답지 참고

final class FileIO {
    private var buffer:[UInt8]
    private var index: Int = 0
    
    init(fileHandle: FileHandle = FileHandle.standardInput) {
        buffer = Array(fileHandle.readDataToEndOfFile())+[UInt8(0)] // 인덱스 범위 넘어가는 것 방지
    }
    
    @inline(__always) private func read() -> UInt8 {
        defer { index += 1 }
        
        return buffer.withUnsafeBufferPointer { $0[index] }
    }
    
    @inline(__always) func readInt() -> Int {
        var sum = 0
        var now = read()
        var isPositive = true
        
        while now == 10
                || now == 32 { now = read() } // 공백과 줄바꿈 무시
        if now == 45{ isPositive.toggle(); now = read() } // 음수 처리
        while now >= 48, now <= 57 {
            sum = sum * 10 + Int(now-48)
            now = read()
        }
        
        return sum * (isPositive ? 1:-1)
    }
    
    @inline(__always) func readString() -> String {
        var str = ""
        var now = read()
        
        while now == 10
                || now == 32 { now = read() } // 공백과 줄바꿈 무시
        
        while now != 10
                && now != 32 && now != 0 {
            str += String(bytes: [now], encoding: .ascii)!
            now = read()
        }
        
        return str
    }
}

let fileIO = FileIO()


let N = fileIO.readInt()
var lines: [(s: Int, e: Int)] = []
for _ in 0..<N {
    let s = fileIO.readInt()
    let e = fileIO.readInt()
    lines.append((s, e))
}

lines.sort {                //각 요소의 첫번째 값
    if $0.s != $1.s {       //두 시작점이 같지 않으면 작은 순서로 정렬
        return $0.s < $1.s
    } else {                //시작점이 같은 경우 더 멀리 있는 끝점 정렬
        return $0.e < $1.e
    }
}

var left = lines[0].s, right = lines[0].e
var result = 0
for i in 0..<N {
    // 선이 겹쳐지지 않을 경우
    if right < lines[i].s {
        // 결과에 더함
        result += right - left
        // 현재 구간을 이번 선분으로 초기화
        left = lines[i].s
        right = lines[i].e
    } else {
        // 선이 겹쳐질 경우 right를 늘림
        right = max(right, lines[i].e)
    }
}
result += right - left

print(result)
