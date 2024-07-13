// import { NextResponse } from 'next/server';
// import type { NextRequest } from 'next/server';

// export function middleware(request: NextRequest) {
//   let cookie = request.cookies.get('JWT-TOKEN');
//   console.log(cookie);
//   const allCookies = request.cookies.getAll();
//   console.log(allCookies);

//   request.cookies.has('nextjs'); // => true
//   request.cookies.delete('nextjs');
//   request.cookies.has('nextjs'); // => false

//   // Setting cookies on the response using the `ResponseCookies` API
//   const response = NextResponse.next();
//   response.cookies.set('JWT-TOKEN', 'fast');
//   response.cookies.set({
//     name: 'vercel',
//     value: 'fast',
//     path: '/',
//   });
//   cookie = response.cookies.get('JWT-TOKEN');
//   console.log('cookie'); // => { name: 'vercel', value: 'fast', Path: '/' }

//   return response;
// }
