package com.greenStudios.objects;

public enum Direction {
	Up(-1, 0), Right(0, 1), Down(1, 0), Left(0, -1), Stop(0, 0);
	public final int X;
	public final int Y;

	Direction (int x, int y) {
		X = x;
		Y = y;
	}
}
