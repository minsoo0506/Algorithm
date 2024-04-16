# [Gold V] Drunk Passenger - 23337 

[문제 링크](https://www.acmicpc.net/problem/23337) 

### 성능 요약

메모리: 14368 KB, 시간: 124 ms

### 분류

다이나믹 프로그래밍, 수학, 확률론

### 제출 일자

2024년 4월 16일 17:38:21

### 문제 설명

<p>Due to COVID-19, social distancing is applied in our daily life to prevent the spread of the disease. It changes our living styles a lot, especially the way of traveling. Now, many carriers cancel non-reserved seats and introduce seating rules to ensure that the distance between any two passengers is long enough.</p>

<p>On your trip to the 2022 ICPC World Finals, you take a flight. The airplane provides n reserved seats to n passengers. The passengers must queue up first; then they board the airplane one by one. You are the last passenger to board, since you are at the end of the queue. Unfortunately, the first passenger is drunk. The drunk passenger randomly goes to another passenger’s seat and then sits there. You may assume the following.</p>

<ol>
	<li>The drunk passenger never takes their own seat.</li>
	<li>The probability of any other seat taken by the drunk passenger is uniform.</li>
</ol>

<p>Luckily, all the other passengers are not drunk. However, they don’t want to move any passenger from a taken seat. If a passenger’s seat has been taken by another passenger when boarding, the passenger would randomly take a vacant seat with equal probability. Otherwise, the passengers just take their own seats.</p>

<p>Please write a program to compute the probability that your seat is taken by another passenger.</p>

### 입력 

 <p>The input contains only one positive integer n.</p>

### 출력 

 <p>Output the probability that your seat is taken by another passenger. It is acceptable if the difference between your output and the answer is less than 10<sup>-6</sup>.'</p>

