# Expenses App

Docker image of this backend is present in --> https://hub.docker.com/u/leandrotula

To perform k8s deployment i'm gonna be using gke.

Once mysql deployment is in running state, we can verify that is working by typing:
kubectl run -it --rm --image=mysql:5.7 --restart=Never mysql-client -- mysql -h <service_name> -p<password>

This project is using github actions. The last step is on charge of pushing the image into my personal docker hub account.
To see more [GitHub Actions](https://github.com/features/actions/).