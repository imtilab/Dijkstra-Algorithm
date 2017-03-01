# Dijkstra-Algorithm

```
Dijkstra(G,s)
01 for each vertex u ϵ G.V()
02    u.setd(∞)
03    u.setparent(NIL)
04 s.setd(0)
05 S <- ∅
06 Q.init(G.V())
07 while not Q.isEmpty()
08    u <- Q.extractMin()
09    S <- S U {u} 
10    for each v ϵ u.adjacent() do
11       Relax(u, v, G)
12       Q.modifyKey(v)

```

---------------------------------

```
dist[s] ←0        	  (distance to source vertex is zero)
for  all v ∈ V–{s}       
    do  dist[v] ←∞ 		(set all other distances to infinity) 
S←∅ 				         (S, the set of visited vertices is initially empty) 
Q←V  				          (Q, the queue initially contains all vertices) 

while Q ≠∅ 			             (while the queue is not empty) 
do  u ← mindistance(Q,dist)  	(select the element of Q with the min. distance) 
  S←S∪{u} 			              (add u to list of visited vertices) 
  for all v ∈ neighbors[u]		 
    do  if dist[v] > dist[u] + w(u, v) 		(if new shortest path found)
      then d[v] ←d[u] + w(u, v)         	(set new value of shortest path)
		    (if desired, add traceback code)
return dist


```


