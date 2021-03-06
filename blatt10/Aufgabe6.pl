blau(sonnalm).
blau(vorkogel).
blau(arbiskogel).
blau(plattenalm).
blau(wiesenalm).

rot(isskogel).

schwatz(teufeltal).

start(sonnalm).
start(teufeltal).

endetIn(vorkogel, isskogel).
endetIn(sonnalm, vorkogel).
endetIn(sonnalm, arbiskoge).
endetIn(arbiskoge, plattenalm).
endetIn(teufeltal, wiesenalm).
endetIn(plattenalm, wiesenalm).
endetIn(wiesenalm, tal).
endetIn(isskogel, tal).

%b) endetIn(X,wiesenalm).
%   X = teufeltal;
%   X = plattenalm.

gleicherStartpunkt(X, Y) :- start(X), start(Y).
gleicherStartpunkt(X, Y) :- endetIn(Z, X), endetIn(Z, Y).

erreichbar(X, Y) :- endetIn(X, Y).
erreichbar(X, Y) :- endetIn(X, Z), erreichbar(Z, Y).

moeglicheSchlusspiste(X, S) :- erreichbar(X, S), endetIn(S, tal).

treffpisten(X, Y, T) := erreichbar(X, T), erreichbar(Y, T), T \= tal.

anfaengerGeeignet(X) :- blau(X), endetIn(X, tal).
anfaengerGeeignet(X) :- blau(X), endetIn(X, Y), anfaengerGeeignet(Y).



% Aufgabe9
list(nil).
list(cons(_, Rest)) :- list(Rest)

pathOfLength(cons(_, nil), 0).
pathOfLength(cons(_,X),s(Y)) :- pathOfLength(X, Y).

add(X, 0, X).
add(X, s(Y),s(Z)):- add(X,Y,Z).

append((nil), Ys, Ys).
append(cons(X, Xs), Ys, cons(X, Zs)):- append(Xs,Ys,Zs).

tour1(cons(tal, nil)).
tour1(cons(tal, cons(X, Xs)) :- start(X), tour(cons(X, Xs)).
tour1(cons(X, cons(Y, Ys))) :- endetIn(X, Y), tour(Y, Ys).

tour(cons(X, Xs)) :- X==tal, tour1(cons(X, Xs)).

tourOfLength(cons(X, Xs), L)) :- pathOfLength(cons(X, Xs), L), tour(cons(X, Xs)).

tourGleich(cons(tal, nil), cons(tal, _)).
tourGleich(cons(X,Xs), cons(Y,Ys)):- X==Y, tourGleich(XS,YS).

cutLast(L1, L2) :- append(L2, [_], L1).

partTour(Xs,Ys) :- tourGleich(Xs, Ys).
partTour(cons(X, Xs), cons(_, Ys)) := partTour(cons(X, Xs), Ys).
partTour(cons(X, Xs), cons(Y, Ys)) := cutLast(cons(Y, Ys), L), partTour(cons(X, Xs), L).

convert(cons(X, nil), [Y]):- X==Y.
convert(cons(X, Xs),[Y, Ys]):- X==Y, convert(Xs,[Ys]).


enumerateTours(T) :- enumerateTours(T,0).

enumerateTours(T,L) :- tourOfLength(X,L) , convert(X,T).
enumerateTours(T,L) :- enumerateTours(T,s(L)).

tourRotSchwarz([tal], 0, 0).
tourRotSchwarz([tal|Rest], Rot, Schwarz) :- enumerateTours([tal|Rest]), tourRotSchwarz2(Rest, Rot, Schwarz).
tourRotSchwarz2([tal], 0, 0).
tourRotSchwarz2([tal|Rest], Rot, Schwarz) :- tourRotSchwarz2(Rest, Rot, Schwarz).
tourRotSchwarz2([Punkt|Rest], Rot, s(Schwarz)) :- schwarz(Punkt), tourRotSchwarz2(Rest, Rot, Schwarz).
tourRotSchwarz2([Punkt|Rest], s(Rot), Schwarz) :- rot(Punkt), tourRotSchwarz2(Rest, Rot, Schwarz).
tourRotSchwarz2([Punkt|Rest], Rot, Schwarz) :- blau(Punkt), tourRotSchwarz2(Rest, Rot, Schwarz).