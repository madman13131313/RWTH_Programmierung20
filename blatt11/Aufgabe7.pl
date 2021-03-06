multiples(X, 1 , [X]).
multiples(X, N, [Y|K]) :- B is N-1, multiples(X, B, K), mult(X, N, Y).

mult(_, 0, 0).
mult(X, Y, Z) :- B is Y-1, mult(X, B, U), Z is X + U.