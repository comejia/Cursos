FROM ubuntu
RUN apt-get update
RUN apt-get install -y python
RUN echo 1.0 >> /etc/version && apt-get install -y git && apt-get install -y iputils-ping
RUN mkdir /datos

WORKDIR /datos
RUN touch f1.txt
RUN mkdir /datos_2
WORKDIR /datos_2
RUN touch f2.txt
#CMD ["echo", "Welcome to this container"]
#CMD ["/bin/bash"]
COPY index.html .
COPY app.log /datos

ADD docs docs
ADD f* /datos/
ADD f.tar .

ENV dir=/data
RUN mkdir $dir

#ARG dir2
#RUN mkdir $dir2

#ARG user
#ENV user_docker $user
#ADD add_user.sh /datos_2
#RUN /datos_2/add_user.sh

##EXPOSE##
RUN apt-get install -y apache2
EXPOSE 80
ADD entrypoint.sh /datos_2

##VOLUME##
ADD paginas /var/www/html
VOLUME ["/var/www/html"]

##CMD##
CMD /datos_2/entrypoint.sh

##ENTRYPOINT##
#ENTRYPOINT ["/bin/bash"]
