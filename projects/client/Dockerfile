FROM node:12.18.4-alpine AS download_slave

WORKDIR /tmp
COPY ./package.json .
RUN npm install


FROM node:12.18.4-buster-slim

WORKDIR /client
COPY --from=download_slave /tmp/node_modules ./node_modules
COPY ./public ./public
COPY ./src ./src 
COPY package.json ./ 

ENV PATH /client/node_modules/.bin:$PATH

EXPOSE 3000

CMD [ "npm","run","start" ]






