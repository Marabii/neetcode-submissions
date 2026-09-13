class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        horizontal = set()
        vertical = set()
        subBox = set()

        #verify horizontal:
        for row in board: #for each row
            for element in row: #for each element in row
                if element != ".":
                    if element in horizontal:
                        return False
                    else:
                        horizontal.add(element)
            horizontal = set()
        
        #verify vertical:
        for i in range(9): #for each column
            for j in range(9): #for each element in column
                element = board[j][i]
                if element != ".":
                    if element in vertical:
                        return False
                    else:
                        vertical.add(element)
            
            vertical = set()
        

        #verify blocks:
        for i in range(3):
            for j in range(3):
                block = [row[3*j: 3*(j+1)] for row in board[3 * i: 3*(i+1)]]
                for row in block:
                    for el in row:
                        if el != ".":
                            if el in subBox:
                                return False
                            subBox.add(el)
                subBox = set()

        return True

                    
