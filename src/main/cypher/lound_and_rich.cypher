match (n) return n;
// [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]]
//         0 1 2 3 4 5 6 7
//quiet = [3,2,5,4,6,1,7,0]

create
  (n0:RichPerson {num:0, quiet:3}),
  (n1:RichPerson {num:1, quiet:2}),
  (n2:RichPerson {num:2, quiet:5}),
  (n3:RichPerson {num:3, quiet:4}),
  (n4:RichPerson {num:4, quiet:6}),
  (n5:RichPerson {num:5, quiet:1}),
  (n6:RichPerson {num:6, quiet:7}),
  (n7:RichPerson {num:7, quiet:0}),

  (n0) -[:Richer]-> (n1),
  (n1) -[:Richer]-> (n2),
  (n1) -[:Richer]-> (n3),
  (n7) -[:Richer]-> (n3),
  (n3) -[:Richer]-> (n4),
  (n3) -[:Richer]-> (n5),
  (n3) -[:Richer]-> (n6)

return n0, n1, n2, n3, n4, n5, n6, n7;


MATCH path=(  (n1:VeryRich) -[:MuchRicher*0..]-> (n2)  )
WITH
  n1,
  reduce(
    min_quiet=n1.quiet,
    n IN nodes(path) |
      CASE
        WHEN n.quite < min_quiet THEN n.quite
        ELSE min_quiet
      END
  ) AS min_quiet
RETURN distinct n1, min_quiet
order by n1.num
