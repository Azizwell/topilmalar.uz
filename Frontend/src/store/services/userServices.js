// Need to use the React-specific entry point to import createApi
import { createApi } from "@reduxjs/toolkit/query/react";
import { axiosBaseQuery } from "../../api/axios";
// Define a service using a base URL and expected endpoints
export const userApi = createApi({
  reducerPath: "userApi",
  baseQuery: axiosBaseQuery({ baseUrl: import.meta.env.VITE_API_URL }),
  endpoints: (builder) => ({
    getUsers: builder.query({
      query: () => ({
        url: "/",
        method: "GET",
      }),
    }),
    register: builder.mutation({
      query: (data) => ({
        url: "auth/register",
        method: "post",
        data,
      }),
    }),
    login: builder.mutation({
      query: (data) => ({
        url: "auth/login",
        method: "post",
        data,
      }),
    }),
    file: builder.mutation({
      query: (data) => ({
        url: "file",
        method: "post",
        headers: {
          "Content-Type": "multipart/form-data",
        },
        data,
      }),
    }),
  }),
});

// Export hooks for usage in functional components, which are
// auto-generated based on the defined endpoints
export const {
  useGetUsersQuery,
  useRegisterMutation,
  useLoginMutation,
  useFileMutation,
} = userApi;
