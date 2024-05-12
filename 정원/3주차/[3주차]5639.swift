import Foundation

var binaryTree = [Int]()

func printBinaryTree(_ first: Int, _ end: Int) {
    if first > end { return }
    var mid = end + 1 // 현재 노드의 값보다 큰 첫 번째 요소의 인덱스를 나타내는 변수를 선언하고 초기화
    // 모든 원소가 루트 노드보다 작을 경우 printBinaryTree(0, end)이 됨
                      // 그러면 오른쪽 노드를 조사할 때 printBinaryTree(end + 1, end)가 되므로 return되고, 이는 오른쪽 노드가 없다는 것을 뜻함
    for i in (first + 1)..<(end + 1) {
        if binaryTree[first] < binaryTree[i] { // 루트 노드보다 큰 원소가 나올 경우
            mid = i // 왼쪽 서브트리와 오른쪽 서브트리를 나누는 지점 할당, 왼쪽 서브트리와 오른쪽 서브트리를 나누는 지점
            break
        }
    }
    
    printBinaryTree(first + 1, mid - 1) // 왼쪽 노드 조사
    printBinaryTree(mid, end) // 오른쪽 노드 조사
    print(binaryTree[first])
}

while let line = readLine() { binaryTree.append(Int(line)!) }
printBinaryTree(0, binaryTree.count - 1)
