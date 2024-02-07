<h2><a href="https://leetcode.com/problems/container-with-most-water/">11. Container With Most Water</a></h2><h3>Medium</h3><hr><div><p><font papago-translate="splitted">You are given an integer array </font><code>height</code><font papago-translate="splitted"> of length </font><code>n</code><font papago-translate="splitted">. There are </font><code>n</code><font papago-translate="splitted"> vertical lines drawn such that the two endpoints of the </font><code>i<sup>th</sup></code><font papago-translate="splitted"> line are </font><code>(i, 0)</code><font papago-translate="splitted"> and </font><code>(i, height[i])</code><font papago-translate="splitted">.</font></p>

<p>Find two lines that together with the x-axis form a container, such that the container contains the most water.</p>

<p>Return <em>the maximum amount of water a container can store</em>.</p>

<p><strong>Notice</strong> that you may not slant the container.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg" style="width: 600px; height: 287px;">
<pre><strong>Input:</strong> height = [1,8,6,2,5,4,8,3,7]
<strong>Output:</strong> 49
<strong>Explanation:</strong> The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> height = [1,1]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == height.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= height[i] &lt;= 10<sup>4</sup></code></li>
</ul>
</div>