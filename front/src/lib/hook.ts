export async function useFetch<T = unknown>(
    eventName: string,
    method: string,
    data?: unknown,
  ): Promise<T> {
    const options = {
      method: method,
      headers: {
        "Content-Type": "application/json; charset=UTF-8",
      },
      body: JSON.stringify(data),
    };
    const resp = await fetch(`${eventName}`, options);
  
    const respFormatted = await resp.json();
  
    return respFormatted;
  }
