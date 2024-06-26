import { NextRequest, NextResponse } from 'next/server';

export function middleware(request: NextRequest) {
  const token = "bearerToken"; 
  if (token) {
    request.headers.set('Authorization', `Bearer ${token}`);
  }
  return NextResponse.next();
}

export const config = {
  matcher: '/api/:path*',
};
