<!DOCTYPE html>
<html>
<body>
    <h1>Ma liste de tâches</h1>

    <form method="POST" action="tasks">
        <input type="text" name="title" placeholder="Nouvelle tâche" required/>
        <button type="submit">Ajouter</button>
    </form>
    <hr/>

    <#if tasks?has_content>
        <ul>
            <#list tasks as task>
                <li>${task.title}</li>
            </#list>
        </ul>
    <#else>
        <p>Aucune tâche pour l'instant.</p>
    </#if>
</body>
</html>
