/**
给定一个整数 n，返回 n! 结果尾数中零的数量。

示例 1:
输入: 3
输出: 0
解释: 3! = 6, 尾数中没有零。

示例 2:
输入: 5
输出: 1
解释: 5! = 120, 尾数中有 1 个零.

说明: 你算法的时间复杂度应为 O(log n) 。
*/

/**
其实，我只要统计参于阶乘计算的所有数字，1,2,3,4...，是哪些导致了最终结果有0。应该是2,5,10,以及他们的倍数。
1,由于2和5结合就是10，所以，这里可以只考虑2和5。
2,最终计算出因数5的重数。那么也至少需要有一样多的2,才能生成10,既成功的在尾部添上0.
3,由于2因数的重数，远大于5的重数，所以算法中可以不计算2的重数(这个定论还未严谨推导)
*/

var pow = function (b,n){
  if (n >= b) {
    var c = Math.floor(n/b);
    return c + pow(b, c);
  }else {
    return 0;
  }
}

/**
 * @param {number} n
 * @return {number}
 */
var trailingZeroes = function(n) {
    var c5 = pow(5,n);
	return c5;
};

/**
以上代码在 https://leetcode-cn.com 提交，显示 
执行用时 68 ms，超过87.13%用户
内存消耗 34.1 MB 超过100%用户
*/


/************************************************/
/**
有一点点不服。再小改一下。去掉递归。节约一点点内存。节约方法调用的上下文切换时间。
*/
/**
 * @param {number} n
 * @return {number}
 */
var trailingZeroes = function(n) {
    var result = 0;
    while (n >= 5) {
        n = Math.floor(n/5);
        result += n;
    }
    return result;
};

/**
执行用时 68 ms，超过87.13%用户
内存消耗 34.2 MB 超过100%用户

几乎没变
*/

