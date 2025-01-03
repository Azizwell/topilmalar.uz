// Need to use the React-specific entry point to import createApi
import { createApi } from "@reduxjs/toolkit/query/react";
import { axiosBaseQuery } from "../../api/axios";
// Define a service using a base URL and expected endpoints
export const globalApi = createApi({
  reducerPath: "globalApi",
  baseQuery: axiosBaseQuery({ baseUrl: import.meta.env.VITE_API_URL }),
  endpoints: (builder) => ({
    getRegions: builder.query({
      query: () => ({
        url: "region",
        method: "GET",
      }),
    }),
    getMarkets: builder.query({
      query: () => ({
        url: "market",
        method: "GET",
      }),
    }),
    getItems: builder.query({
      query: () => ({
        url: "item",
        method: "GET",
      }),
    }),
    getCarouselInfo: builder.query({
      query: () => ({
        url: "carousel",
        method: "GET",
      }),
    }),
    getMyQuery: builder.query({
      query: (data) => ({
        url: `applicant?${data.type != "" ? `type=${data.type}` : ""}${
          data.status != "" ? `&status=${data.status}` : ""
        }${data.miniType != "" ? `&miniType=${data.miniType}` : ""}${
          data.region != "" ? `&region=${data.region}` : ""
        }${data.district != "" ? `&district=${data.district}` : ""}${
          data.serialNumber != "" ? `&serialNumber=${data.serialNumber}` : ""
        }`,
        method: "GET",
      }),
    }),
    addApplicant: builder.mutation({
      query: (data) => ({
        url: "applicant",
        method: "post",
        data,
      }),
    }),
    addDocument: builder.mutation({
      query: (data) => ({
        url: "document",
        method: "post",
        data,
      }),
    }),
    addItem: builder.mutation({
      query: (data) => ({
        url: "item",
        method: "post",
        data,
      }),
    }),
    getOneReestr: builder.mutation({
      query: (reestrId) => ({
        url: `reestr?reestrId=${reestrId}`,
        method: "PATCH",
      }),
    }),
    getRegionStat: builder.query({
      query: () => ({
        url: "region_stat",
        method: "GET",
      }),
    }),
    getGlobalStat: builder.query({
      query: () => ({
        url: "statistic",
        method: "GET",
      }),
    }),
  }),
});

// Export hooks for usage in functional components, which are
// auto-generated based on the defined endpoints
export const {
  useGetItemsQuery,
  useGetRegionsQuery,
  useAddApplicantMutation,
  useGetMarketsQuery,
  useAddDocumentMutation,
  useAddItemMutation,
  useGetMyQueryQuery,
  useGetOneReestrMutation,
  useGetCarouselInfoQuery,
  useGetRegionStatQuery,
  useGetGlobalStatQuery
} = globalApi;
