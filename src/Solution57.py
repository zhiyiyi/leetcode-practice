class Solution:
    def insert(self, intervals: list[list[int]], newInterval: list[int]) -> list[list[int]]:
        res = []
        for i in range(len(intervals)):
            if (newInterval[1] < intervals[i][0]):
                res.append(newInterval)
                return res + intervals[i:]
            elif (newInterval[0] > intervals[i][1]):
                res.append(intervals[i])
            else:
                newInterval[0] = min(newInterval[0], intervals[i][0])
                newInterval[1] = max(newInterval[1], intervals[i][1])

        res.append(newInterval)
        return res

    def main(self) -> list[list[int]]:
        intervals = [[1, 3], [4, 6], [7, 9]]
        newInterval = [2, 8]
        print(self.insert(intervals, newInterval))


if __name__ == '__main__':
    Solution().main()
